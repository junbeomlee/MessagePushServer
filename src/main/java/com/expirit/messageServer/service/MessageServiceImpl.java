package com.expirit.messageServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expirit.messageServer.domain.Status;
import com.expirit.messageServer.domain.StatusRepository;
import com.expirit.messageServer.dto.MessageDTO;

import rx.Observable;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	StatusRepository statusRepository;


	@Override
	public Observable<Void> sendMessage(MessageDTO messageDTO, String clientId) {
		// TODO Auto-generated method stub
		return Observable.create(sub->{
			Status status=statusRepository.get(clientId);
			if(status==null){
				
			}else{
				
			}
			sub.onNext(null);
			sub.onCompleted();
		});
	}

}
