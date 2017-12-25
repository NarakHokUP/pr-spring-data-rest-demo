package com.phearun.event;

import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterLinkDelete;
import org.springframework.data.rest.core.annotation.HandleAfterLinkSave;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeLinkDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeLinkSave;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import com.phearun.model.Book;

@Component
@RepositoryEventHandler
public class BookEventHandler {

	// TODO: save event handler
	@HandleBeforeSave
	public void handleBeforeSave(Book book) {
		System.out.println("BeforeSave: " + book);
	}

	@HandleAfterSave
	public void handleAfterSave(Book book) {
		System.out.println("AfterSave: " + book);
	}
	
	// TODO: create event handler
	@HandleBeforeCreate
	public void handleBeforeCreate(Book book) {
		System.out.println("BeforeCreate: " + book);
	}

	@HandleAfterCreate
	public void handleAfterCreate(Book book) {
		System.out.println("AfterCreate: " + book);
	}

	// TODO: delete event handler
	@HandleBeforeDelete
	public void handleBeforeDelete(Book book) {
		System.out.println("BeforeDelete: " + book);
	}

	@HandleAfterDelete
	public void handleAfterDelete(Book book) {
		System.out.println("AfterDelete: " + book);
	}

	// TODO: link save event handler
	@HandleBeforeLinkSave
	public void handleBeforeLinkSave(Book book) {
		System.out.println("BeforeLinkSave: " + book);
	}

	@HandleAfterLinkSave
	public void handleAfterLinkSave(Book book) {
		System.out.println("AfterLinkSave: " + book);
	}

	// TODO: link delete event handler
	@HandleBeforeLinkDelete
	public void handleBeforeLinkDelete(Book book) {
		System.out.println("BeforeLinkDelete: " + book);
	}

	@HandleAfterLinkDelete
	public void handleAfterLinkDelete(Book book) {
		System.out.println("AfterLinkDelete: " + book);
	}

}
