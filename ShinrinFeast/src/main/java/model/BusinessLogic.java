package model;

import java.util.ArrayList;
import java.util.List;

public class BusinessLogic {
	
	public boolean executeInsertSurvey(ShinrinDto dto) {
		boolean   succesInsert = false ;
		ShinrinDao dao = new ShinrinDao();
		succesInsert = dao.doInsert(dto);
		return succesInsert;
	}
	
	public List<ShinrinDto> executeSelectSurveyBySatisfactionLevel( String sl ) {
		List<ShinrinDto> surveyList = new ArrayList<ShinrinDto>();
		ShinrinDao dao = new ShinrinDao();
		surveyList = dao.doSelectBySatisfactionLevel( sl );
		return surveyList;
	}
}