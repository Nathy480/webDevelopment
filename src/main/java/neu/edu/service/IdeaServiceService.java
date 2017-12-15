package neu.edu.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.ideaservice.IdeaServiceModel;
import neu.edu.dao.IdeaServiceDao;
import neu.edu.entity.IdeaService;

@Service
public class IdeaServiceService {

	@Autowired
	private IdeaServiceDao ideaServiceDao;

	@Transactional
	public List<IdeaServiceModel> findAll() {
		// TODO Auto-generated method stub
		return ideaServiceDao.findAll().stream().map(x -> {
			IdeaServiceModel temp = new IdeaServiceModel(x.getIdeaServiceId());

			return temp;
		}).collect(Collectors.toList());
	}

	// createideaService
	@Transactional
	public Integer createideaService(IdeaServiceModel ideaServiceModel) {

		
		IdeaService ideaService = new IdeaService();
	//	ideaService.setIdea(ideaServiceModel.getIdea().getIdeaId());
	
		
		System.out.println("Services created " + ideaService.getIdeaServiceId());
		return ideaService.getIdeaServiceId();

	}

}
