package yamp.com.controller;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import yamp.com.common.ResponseJsonPageListBean;
import yamp.com.mapper.BillMapper;
import yamp.com.mapper.GoodsMapper;
import yamp.com.model.Bill;
import yamp.com.model.BillExample;
import yamp.com.model.Goods;
import yamp.com.model.SysUser;
import yamp.com.pojo.GoodsExtendsPojo;
import yamp.com.pojo.IntoOutCountPojo;
import yamp.com.util.DateUtil;
import yamp.com.util.JsonPrintUtil;
import yamp.com.util.JsonUtils;

@Controller
@RequestMapping("bill")
public class BillController {
	@Autowired
	private BillMapper billMapper;
	@Autowired
	private GoodsMapper goodsMapper;

	// 账单列表分页查询
	@RequestMapping("list")
	@ResponseBody
	public void getList(HttpServletRequest request, HttpServletResponse response, Integer intoOrOutStatus,String keywords, int limit,
			int page) {
		// limit 每页显示数量
		// page 当前页码
		BillExample example = new BillExample();
		// 设置分页查询参数
		example.setStartRow((page - 1) * limit);
		example.setPageSize(limit);
		example.setOrderByClause("player_time desc");
		BillExample.Criteria criteria = example.createCriteria();
		if(intoOrOutStatus!=null) {
			if (keywords != null && keywords != "") {
				keywords = keywords.trim();
				keywords = "%" + keywords + "%";
				// and or联合查询
				example.or().andOrderCodeLike(keywords).andStatusEqualTo(1).andIntoOrOutStatusEqualTo(intoOrOutStatus);
			} else {
				criteria.andStatusEqualTo(1).andIntoOrOutStatusEqualTo(intoOrOutStatus);// 正常状态
			}	
		}else {
			if (keywords != null && keywords != "") {
				keywords = keywords.trim();
				keywords = "%" + keywords + "%";
				// and or联合查询
				example.or().andOrderCodeLike(keywords).andStatusEqualTo(1);
			} else {
				criteria.andStatusEqualTo(1);// 正常状态
			}
		}
		
		// 分页查询
		List<Bill> billList = billMapper.selectByExample(example);
		int count = (int) billMapper.countByExample(example);

		ResponseJsonPageListBean listBean = new ResponseJsonPageListBean();
		listBean.setCode(0);
		listBean.setCount(count);
		listBean.setMsg("账单列表");
		listBean.setData(billList);

		// 日志记录及输出前台Json
		if (null != billList && billList.size() > 0) {
			JsonPrintUtil.printObjDataWithoutKey(response, listBean);
		} else {
			JsonPrintUtil.printObjDataWithoutKey(response, null);
		}
	}

	// 账单新增 编辑
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public void save(Bill bill, HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		int count = 0;
		SysUser currentLoginUser = (SysUser) session.getAttribute("CurrentLoginUserInfo");
		// 编辑账单
		if (null != bill.getId() && bill.getId() > 0) {

			count = billMapper.updateByPrimaryKeySelective(bill);

		} else {
			// 更新库存
			List<GoodsExtendsPojo> list = JsonUtils.jsonToList(bill.getGoodsIds(), GoodsExtendsPojo.class);
			// 进货 状态 0
			if(list!=null&list.size()>0) {
			if (bill.getIntoOrOutStatus().equals(0)) {
				for (GoodsExtendsPojo goodsExtendsPojo : list) {
					Goods goodsSql = goodsMapper.selectByPrimaryKey(goodsExtendsPojo.getId());
					goodsSql.setBoxBidPrice(goodsExtendsPojo.getBoxBidPrice());
					goodsSql.setBranchBidPrice(goodsExtendsPojo.getBranchBidPrice());
					goodsSql.setBoxPrice(goodsExtendsPojo.getBoxPrice());
					goodsSql.setBranchPrice(goodsExtendsPojo.getBranchPrice());
					goodsSql.setBoxCount(goodsSql.getBoxCount() + goodsExtendsPojo.getBoxCount());
					goodsSql.setBranchCount(goodsSql.getBranchCount() + goodsExtendsPojo.getBranchCount());
					goodsMapper.updateByPrimaryKeySelective(goodsSql);
				}
				// 销售 状态 1
			} else {
				for (GoodsExtendsPojo goodsExtendsPojo : list) {
					Goods goodsSql = goodsMapper.selectByPrimaryKey(goodsExtendsPojo.getId());
					goodsSql.setBoxCount(goodsSql.getBoxCount() - goodsExtendsPojo.getBoxCount());
					goodsSql.setBranchCount(goodsSql.getBranchCount() - goodsExtendsPojo.getBranchCount());
					goodsMapper.updateByPrimaryKeySelective(goodsSql);
				}
			}
			}
			// 新增账单
			bill.setStatus(1);
			bill.setLineOrderStatus(1);
			bill.setCreater(currentLoginUser.getName() + "");
			bill.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
			count = billMapper.insert(bill);
			// 输出前台Json

		}
		JsonPrintUtil.printObjDataWithKey(response, count, "data");
	}

	// 账单批量删除
	@RequestMapping(value = "deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public void deleteBatch(String idStr, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		SysUser currentLoginUser = (SysUser) session.getAttribute("CurrentLoginUserInfo");
		if (StringUtils.isNotBlank(idStr)) {
			String[] idArr = idStr.split(",");
			for (int i = 0; i < idArr.length; i++) {
				// 更新所选设备分类为删除状态
				int id = Integer.parseInt(idArr[i]);
				Bill bill = billMapper.selectByPrimaryKey(id);
				bill.setStatus(0);// 0已删除
				// bill.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
				// bill.setUpdater(currentLoginUser.getName() + "");
				billMapper.updateByPrimaryKeySelective(bill);
			}
			// 输出前台Json
			JsonPrintUtil.printObjDataWithKey(response, 1, "data");
		} else {
			JsonPrintUtil.printObjDataWithKey(response, 0, "data");
		}
	}

	// 账单查看
	@RequestMapping(value = "show", method = RequestMethod.POST)
	@ResponseBody
	public void show(int id, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		Bill bill = billMapper.selectByPrimaryKey(id);
		if (null != bill) {
			JsonPrintUtil.printObjDataWithKey(response, bill, "data");
		} else {
			JsonPrintUtil.printObjDataWithKey(response, null, "data");
		}
	}

	// 收入/支出统计
	@RequestMapping(value = "intoOutCount", method = RequestMethod.POST)
	@ResponseBody
	public void intoOutCount(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		IntoOutCountPojo intoOutCountPojo = new IntoOutCountPojo();
		DecimalFormat df = new DecimalFormat("#.00");
		// 进货统计
		BillExample example = new BillExample();
		BillExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(1).andLineOrderStatusEqualTo(1).andIntoOrOutStatusEqualTo(0);
		List<Bill> billList = billMapper.selectByExample(example);
		if (billList.size() > 0 && billList != null) {
			for (Bill bill : billList) {
				intoOutCountPojo.setIntoCount(intoOutCountPojo.getIntoCount() + bill.getTransaction());
			}
		}

		// 销售统计
		BillExample example2 = new BillExample();
		BillExample.Criteria criteria2 = example.createCriteria();
		criteria2.andStatusEqualTo(1).andLineOrderStatusEqualTo(1).andIntoOrOutStatusEqualTo(1);
		List<Bill> billList2 = billMapper.selectByExample(example2);
		if (billList2.size() > 0 && billList2 != null) {
			for (Bill bill : billList2) {
				intoOutCountPojo.setOutCount(intoOutCountPojo.getOutCount() + bill.getTransaction());
			}
		}
		intoOutCountPojo.setSumCount(intoOutCountPojo.getIntoCount() + intoOutCountPojo.getOutCount());
		if (intoOutCountPojo.getSumCount() != 0) {
			intoOutCountPojo.setIntoCountPercent(
					Double.parseDouble(df.format(intoOutCountPojo.getIntoCount() / intoOutCountPojo.getSumCount())));
			intoOutCountPojo.setOutCountPercent(
					Double.parseDouble(df.format(intoOutCountPojo.getOutCount() / intoOutCountPojo.getSumCount())));
		}

		JsonPrintUtil.printObjDataWithKey(response, intoOutCountPojo, "data");
	}

}
