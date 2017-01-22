package com.expirit.messageServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expirit.messageServer.dto.MessageDTO;
import com.expirit.messageServer.service.MessageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MessageController {

	@Autowired
	MessageService messageService;
	
	@RequestMapping(value="/messages/{clientId}", method=RequestMethod.POST)
	public void postMessage(@RequestBody MessageDTO messageDTO,
							@PathVariable("clientId") String clientId){
		
		messageService.sendMessage(messageDTO,clientId);
	}
}
