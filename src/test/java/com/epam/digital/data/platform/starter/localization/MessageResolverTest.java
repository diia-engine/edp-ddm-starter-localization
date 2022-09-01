/*
 * Copyright 2021 EPAM Systems.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.epam.digital.data.platform.starter.localization;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.digital.data.platform.starter.localization.config.LocalizationAutoConfiguration;
import com.epam.digital.data.platform.starter.localization.enums.TestEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import(LocalizationAutoConfiguration.class)
public class MessageResolverTest {

  @Autowired
  private MessageResolver messageResolver;

  @Test
  public void testMessageResolver() {
    var result = messageResolver.getMessage(TestEnum.TEST_ENUM);

    assertThat(result).isEqualTo("Test message value");
  }

  @Test
  public void testMessageResolverWithParams() {
    var param = "param1";

    var result = messageResolver.getMessage(TestEnum.TEST_ENUM_WITH_PARAM, param);

    assertThat(result).isEqualTo("Test message value with param param1");
  }
}
