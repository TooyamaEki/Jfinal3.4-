package com.kakuhanashi.service;

import com.kakuhanashi.common.model.User;
import com.kakuhanashi.common.model.Words;

public class WorksService {
 public static final WorksService me = new WorksService();
 Words dao = new Words().dao();
 
}
