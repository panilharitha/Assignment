package pwc.com.au.assignment.common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CacheUtil {
	public static Map<String, Map<String, String>> cache = Collections
			.synchronizedMap(new HashMap<String, Map<String, String>>());

	private CacheUtil() {
	}

	public static void put(String cacheKey, Map<String, String> value) {
		cache.put(cacheKey, value);
	}

	public static Object get(String cacheKey) {
		return cache.get(cacheKey);
	}

	public static void remove(String cacheKey) {
		cache.remove(cacheKey);
	}

	public void clear() {
		cache.clear();
	}
}
