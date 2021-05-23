package io.kodlama.Business.Abstracts;

import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.Concretes.BusinessSectorsEntity;

import java.util.List;
public interface BusinessAreaServices {

	List<BusinessSectorsEntity> getAll();
	Result insert(BusinessSectorsEntity businessAreas);

}
