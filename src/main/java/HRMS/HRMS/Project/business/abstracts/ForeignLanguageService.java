package HRMS.HRMS.Project.business.abstracts;

import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.entities.concretes.ForeignLanguage;

import java.util.List;

public interface ForeignLanguageService {
    Result add(ForeignLanguage foreignLanguage);
    DataResult<List<ForeignLanguage>> getAll();
}
