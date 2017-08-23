package com.sk.taxcalculator.dao;

public class DaoFactory {
  
  private static ProductDao productDao;
  static {
    productDao = new ProductDao();
  }

  public static enum Daos {
    PRODUCT;
  }
  
  @SuppressWarnings("rawtypes")
  public static BaseDaoImpl getDao(Daos dao) {
    switch (dao) {
      case PRODUCT:
        return productDao;

      default:
        return null;
    }
  }
}
