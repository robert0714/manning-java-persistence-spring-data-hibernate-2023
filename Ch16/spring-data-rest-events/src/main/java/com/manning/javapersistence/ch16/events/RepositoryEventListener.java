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

import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class RepositoryEventListener extends
        AbstractRepositoryEventListener<User> { 
    @Override
    public void onBeforeCreate(User user) {
        log.info("I'll make an effort to create this user {}" , user.getName());
    }

    @Override
    public void onAfterCreate(User user) {
        log.info("I did my best and I was able to create " + user.getName());
    }

    @Override
    public void onBeforeSave(User user) {
        log.info("I'll take a breath and I will save " + user.getName());
    }

    @Override
    public void onAfterSave(User user) {
        log.info("Hard, hard to save " + user.getName());
    }

    @Override
    public void onBeforeDelete(User user) {
        log.warn("I'll delete " + user.getName() + ", you might never see him/her again");
    }

    @Override
    public void onAfterDelete(User user) {
        log.warn("Say good-bye to " + user.getName() + ", I deleted him/her");
    }
}
