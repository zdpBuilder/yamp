package yamp.com.controller.web;


import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import yamp.com.mapper.BillMapper;
import yamp.com.mapper.GoodsMapper;
import yamp.com.model.Bill;
import yamp.com.model.Goods;
import yamp.com.pojo.GoodsExtendsPojo;
import yamp.com.util.DateUtil;
import yamp.com.util.JsonUtils;

@Controller
@RequestMapping("appBill")
public class AppBillController {
	@Autowired
	private BillMapper billMapper;
	@Autowired
	private GoodsMapper goodsMapper;

	// 账单新增 
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public Integer save(Bill bill) {	
			// 更新库存
			List<GoodsExtendsPojo> list = JsonUtils.jsonToList(bill.getGoodsIds(), GoodsExtendsPojo.class);
			if(list!=null&list.size()>0) {
				for (GoodsExtendsPojo goodsExtendsPojo : list) {
					Goods goodsSql = goodsMapper.selectByPrimaryKey(goodsExtendsPojo.getId());
					goodsSql.setBoxCount(goodsSql.getBoxCount() - goodsExtendsPojo.getBoxCount());
					goodsSql.setBranchCount(goodsSql.getBranchCount() - goodsExtendsPojo.getBranchCount());
					goodsMapper.updateByPrimaryKeySelective(goodsSql);
				}		
			}
			//新增账单
			bill.setCreater(bill.getPlayer() + "");
			bill.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));			
    return billMapper.insert(bill);
	}
}
