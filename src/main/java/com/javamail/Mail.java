package com.javamail;

import java.io.File;
import java.util.List;

public interface Mail {

	String getSubject();

	String getBody();

	List<File> getAttachment();

	Config getConfig();

}
