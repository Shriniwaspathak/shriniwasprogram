package com.bridgelab.stock.service;

import com.bridgelab.stock.model.CompanyShare;

public interface StockInterface {
	public void buy();

	public void sale();

	public void printReport();

	public void jsonReadUser();

	public void jsonReadCompany();

	public void save(int totalvalue, CompanyShare companyshare);

	public void writeUser();

	public void writeCompany();

}
