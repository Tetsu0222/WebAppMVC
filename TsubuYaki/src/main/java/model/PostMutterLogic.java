package model;

import java.util.List;

public class PostMutterLogic {

  public List<Mutter> executeSelect() {
	  MutterDAO dao = new MutterDAO();
	  List<Mutter> list = dao.doSelect();
	  return list;
  }

  public void executeInsert ( Mutter mutter ) {
	  MutterDAO dao = new MutterDAO();
	  dao.doInsert(mutter);
  }
}