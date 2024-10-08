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
package com.manning.javapersistence.springdatamongodb.template;

import com.manning.javapersistence.springdatamongodb.GenerateUsers;
import com.manning.javapersistence.springdatamongodb.model.Address;
import com.manning.javapersistence.springdatamongodb.model.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import static com.manning.javapersistence.springdatamongodb.GenerateUsers.generateUsers;
/**
 * https://www.baeldung.com/junit-testinstance-annotation
 * **/
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class SpringDataMongoDBApplicationTests {

    @Autowired
    MongoTemplate mongoTemplate;

    @BeforeAll
    void beforeAll() { 
        mongoTemplate.insert(GenerateUsers.address);
        mongoTemplate.insert(generateUsers(), User.class);
    }

    @AfterAll
    void afterAll() {
        mongoTemplate.remove(new Query(), User.class);
        mongoTemplate.remove(new Query(), Address.class);
    }
}
