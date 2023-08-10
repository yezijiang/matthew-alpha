package com.matthew.javabase.java8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-03-25 15:33
 */
public class StreamTest {
	@Test
	public void forEach() {
		// 你不鸟我,我也不鸟你
		List<String> list = Arrays.asList("you", "don't", "bird", "me", ",",
				"I", "don't", "bird", "you");

		// 方式一：JDK1.8之前的循环方式
		for (String item : list) {
			System.out.println(item);
		}

		// 方式二：使用Stream的forEach方法
		// void forEach(Consumer<? super T> action)
		list.stream().forEach(item -> System.out.println(item));

		// 方式三：方式二的简化方式
		// 由于方法引用也属于函数式接口，所以方式二Lambda表达式也可以使用方法引用来代替
		list.stream().forEach(System.out::println);
		/**
		 * 其中stream（）方法是collection的默认方法，只要collection继承实现体系才有，比如map就没有
		 */
	}

	@Test
	public void filter() {
		List<String> list = Arrays.asList("you", "don't", "bird", "me", ",",
				"I", "don't", "bird", "you");
		list.stream().filter(item -> item.startsWith("d")).forEach(System.out::println);

	}

	@Test
	public void map() {
		List<String> list = Arrays.asList("how", "are", "you", "how", "old", "are", "you", "?");
		list.stream().map(item -> item.toUpperCase()).forEach(System.out::println);
	}

	public void mapToLong() {

	}

	@Test
	public void flatMap() {
		List<Integer> a = Arrays.asList(1, 2, 3);
		List<Integer> b = Arrays.asList(4, 5, 6);
		List<List<Integer>> collect = Stream.of(a, b).collect(Collectors.toList());
		System.out.println(collect);
		//将多个集合中的元素合并成一个集合
		List<Integer> mergedList = Stream.of(a, b).flatMap(list -> list.stream()).collect(Collectors.toList());
		System.out.println(mergedList);

	}

	@Test
	public void distinct() {
		//去重复
		List<String> list = Arrays.asList("how", "are", "you", "how", "old", "are", "you", "?");
		list = list.stream().distinct().collect(Collectors.toList());
		System.out.println(list);
	}

	@Test
	public void sorted() {
		List<String> list = Arrays.asList("c", "e", "a", "d", "b");
		list.stream().sorted((s1, s2) -> s1.compareTo(s2)).forEach(System.out::println);
	}

	public void peek() {

	}

	@Test
	public void limit() {
		List<String> list = Arrays.asList("a", "b", "c", "d", "e");
		list.stream().skip(2).limit(2).forEach(System.out::println);    // c、d
	}

	@Test
	public void skip() {
		List<String> list = Arrays.asList("a", "b", "c", "d", "e");
		// Stream<T> skip(long n)
		list.stream().skip(2).forEach(System.out::println);  // c、d、e
	}

	@Test
	public void reduce() {
		//归纳
		Stream<String> stream = Stream.of("you", "give", "me", "stop");
		// Optional<T> reduce(BinaryOperator<T> accumulator);
		Optional<String> optional = stream.reduce((before, after) -> before + "," + after);
		optional.ifPresent(System.out::println);    // you,give,me,stop
	}

	@Test
	public void collect() {
		List<String> list = Arrays.asList("a", "b", "c", "d", "e");
		// Stream -> Collection
		List<String> collect = list.stream().collect(Collectors.toList());

		// Stream -> Object[]
		Object[] objects = list.stream().toArray();
	}

	@Test
	public void min() {
		List<String> list = Arrays.asList("1", "2", "3", "4", "5");
		// Optional<T> min(Comparator<? super T> comparator);
		Optional<String> optional = list.stream().min((a, b) -> a.compareTo(b));
		String value = optional.get();
		System.out.println(value);
	}

	@Test
	public void match() {
		// 你给我站住
		List<String> list = Arrays.asList("you", "give", "me", "stop");
		// boolean anyMatch(Predicate<? super T> predicate);
		// parallelStream可以并行计算，速度比stream更快
		boolean result = list.parallelStream().anyMatch(item -> item.equals("me"));
		System.out.println(result);
	}

	/**
	 * 如果集合中有一个元素满足条件就返回true
	 *
	 * @return
	 */
	public boolean anyMatch() {
		List<String> list = Arrays.asList("you", "give", "me", "stop");
		for (String item : list) {
			if (item.equals("me")) {
				return true;
			}
		}

		return false;
	}

	@Test
	public void findFirst() {
		Stream<String> stream = Stream.of("you", "give", "me", "stop");
		String value = stream.findFirst().get();
		System.out.println(value);
	}

	@Test
	public void findAny() {
		Stream<String> stream = Stream.of("you", "give", "me", "stop");
		String value2 = stream.findAny().get();
		System.out.println(value2);
	}
}
