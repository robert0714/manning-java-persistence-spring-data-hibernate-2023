/*
 * ========================================================================
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ========================================================================
 */
package com.manning.javapersistence.ch16.events;

import com.manning.javapersistence.ch16.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.*;
import org.springframework.stereotype.Service;

@Slf4j
@RepositoryEventHandler
@Service
public class UserRepositoryEventHandler { 
    @HandleBeforeCreate
    public void handleUserBeforeCreate(User user) {
        if ((user.getName().toUpperCase().charAt(0) >= 'A') && (user.getName().toUpperCase().charAt(0) <= 'M')) {
            log.info("User " + user.getName() + " is to be created, goes to the first part of the alphabet");
        } else {
            log.info("User " + user.getName() + " is to be created, goes to the second part of the alphabet");
        }
    }

    @HandleAfterCreate
    public void handleUserAfterCreate(User user) {
        log.info("I am so tired to have created " + user.getName());
    }

    @HandleBeforeDelete
    public void handleUserBeforeDelete(User user) {
        log.warn("This is just to let you know that " + user.getName() + " is about to be deleted");
    }

    @HandleAfterDelete
    public void handleUserAfterDelete(User user) {
        log.warn("Sad but true, " + user.getName() + " has been deleted");
    }

}
