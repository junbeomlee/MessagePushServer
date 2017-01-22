package com.expirit.messageServer.service;

import com.expirit.messageServer.dto.MessageDTO;

import rx.Observable;

public interface MessageService {
	public Observable<Void> sendMessage(MessageDTO messageDTO, String clientId);
}
