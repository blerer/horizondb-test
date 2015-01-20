/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.horizondb.test;

import static org.junit.Assert.assertTrue;

/**
 * Asserts utilities for exception.
 */
public final class AssertExceptions {

    /**
     * Verify that the message of the specified <code>Exception</code> contains the specified text.
     * 
     * @param text the text that the message must contains 
     * @param e the <code>Exception</code>
     */
    public static void assertErrorMessageContains(String text, Exception e) {
        assertTrue(String.format("the message was expected to contains '%s' but does not. Message: %s ",
                                 text,
                                 e.getMessage()),
                   e.getMessage().contains(text));
    }

    private AssertExceptions() {

    }
}
