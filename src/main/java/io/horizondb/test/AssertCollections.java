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

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Asserts utilities for collections.
 */
public final class AssertCollections {

    /**
     * Verify that the specified iterator contains the specified elements in the specified order.
     * 
     * @param <E> the element type
     * @param iterator the iterator to verify.
     * @param expectedElements the expected elements.
     */
    @SafeVarargs
    public static <E> void assertIteratorContains(Iterator<E> iterator, E... expectedElements) {

        int i = 0;

        for (E expectedElement : expectedElements) {

            assertTrue("The iterator contains only " + i + " elements but " + expectedElements.length
                    + " were expected", iterator.hasNext());
            assertEquals(expectedElement, iterator.next());

            i++;
        }

        assertFalse(iterator.hasNext());
    }

    /**
     * Verify that the specified iterable contains the specified elements in the specified order.
     * 
     * @param <E> the element type
     * @param iterable the iterable to verify.
     * @param expectedElements the expected elements.
     */
    @SafeVarargs
    public static <E> void assertIterableContains(Iterable<E> iterable, E... expectedElements) {

        assertIteratorContains(iterable.iterator(), expectedElements);
    }

    /**
     * Verifies that the specified list contains the specified elements in the specified order.
     * 
     * @param <E> the element type
     * @param list the list to verify.
     * @param expectedElements the expected elements.
     */
    @SafeVarargs
    public static <E> void assertListContains(List<E> list, E... expectedElements) {

        assertEquals("the size of the list does not match the expected one.", expectedElements.length, list.size());

        assertIteratorContains(list.iterator(), expectedElements);
    }

    /**
     * Verifies that the specified collection contains the specified elements.
     * 
     * @param <E> the element type
     * @param collection the collection to verify.
     * @param expectedElements the expected elements.
     */
    @SafeVarargs
    public static <E> void assertCollectionContains(Collection<E> collection, E... expectedElements) {

        assertEquals(expectedElements.length, collection.size());

        for (int i = 0, m = collection.size(); i < m; i++) {
            assertTrue("the collection: " + collection + " does not contains the element: " + expectedElements[i],
                       collection.contains(expectedElements[i]));
        }
    }
    
    /**
     * Verifies that the specified map contains only the specified key with the specified value.
     * 
     * @param <K> the key type
     * @param <V> the value type
     * @param map the map to verify
     * @param key the expected key
     * @param value the expected key value
     */
    public static <K, V> void assertMapContains(Map<K, V> map, K key, V value) {
        
        assertEquals("the size of the map does not match the expected one.", 1, map.size());
        
        assertTrue("the map " + map + " does not contains the key: " + key, map.containsKey(key));
        assertEquals(map.get(key), value);
    }

    /**
     * Verifies that the specified map contains only the specified key with the specified value.
     * 
     * @param <K> the key type
     * @param <V> the value type
     * @param map the map to verify
     * @param key1 the expected first key
     * @param value1 the expected first key value
     */
    public static <K, V> void assertMapContains(Map<K, V> map, K key1, V value1, K key2, V value2) {
        
        assertEquals("the size of the map does not match the expected one.", 2, map.size());
        
        assertTrue("the map " + map + " does not contains the key: " + key1, map.containsKey(key1));
        assertEquals(map.get(key1), value1);
        
        assertTrue("the map " + map + " does not contains the key: " + key2, map.containsKey(key2));
        assertEquals(map.get(key2), value2);
    }
    
    /**
     * Verifies that the specified array contains the specified elements in the specified order.
     * 
     * @param <E> the element type
     * @param array the array to verify.
     * @param expectedElements the expected elements.
     */
    @SafeVarargs
    public static <E> void assertArrayContains(E[] array, E... expectedElements) {

        assertEquals(expectedElements.length, array.length);

        for (int i = 0, m = array.length; i < m; i++) {
            assertEquals(expectedElements[i], array[i]);
        }
    }

    /**
     * This class should not be instantiated.
     */
    private AssertCollections() {
    }
}
