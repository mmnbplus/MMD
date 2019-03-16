package com.mmd.mmdshop.controller.commodity;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.mmd.mmdshop.dbdo.CommodityDO;

/**
 * 
 * @ClassName CommodityController_Consumer.java
 * @author MM
 * @version 2.0
 * @date 2019/2/18
 */
@RestController
public class CommodityController_Consumer {
protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private final static String ADMINUSERPROVIDER_URL = "http://localhost:8001/provider";
	
	@Autowired
	private RestTemplate template;
	
	/**
	 * 补货
	 * @param marketResult
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/provider/replenishmentCommodityNumber")
	public List<CommodityDO> replenishmentCommodityNumber(@RequestBody int shopId) {
		return template.postForObject(ADMINUSERPROVIDER_URL+"replenishmentCommodityNumber", shopId, List.class);
	}
}