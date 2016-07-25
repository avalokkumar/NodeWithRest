package com.poc.model;

import java.util.concurrent.atomic.AtomicLong;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"id", "content"})
public class Greeting {

	@XmlElement
    private final long id;
	@XmlElement
    private final String content;

    public Greeting(){
    	this.id = new AtomicLong().incrementAndGet();
    	this.content ="Hello Clayman";
	}
    
    public Greeting(long id, String content){
    	this.id = id;
    	this.content = content;
    }
    
    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}