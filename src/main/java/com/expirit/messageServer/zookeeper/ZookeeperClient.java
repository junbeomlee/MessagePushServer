package com.expirit.messageServer.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.AsyncCallback.StatCallback;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ZookeeperClient implements StatCallback {

	private String watcherMqttNode="/mqtt";
	
	@Autowired
	public ZookeeperClient(ZookeeperConnector zc){
		
		try {
			ZooKeeper zk=zc.connect("localhost");
			//zk.exists(watcherMqttNode, true,this,null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void processResult(int arg0, String arg1, Object arg2, Stat arg3) {
		// TODO Auto-generated method stub
		
	}
}
