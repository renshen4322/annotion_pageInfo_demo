package com.dn.estest.script;


import lombok.Data;

import java.util.List;

@Data
public class DynamicPriceTemplate {
	private int goodsId;
	private String goodName;
	private List<Rule> rules;


}
