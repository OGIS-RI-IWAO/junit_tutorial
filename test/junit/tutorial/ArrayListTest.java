package junit.tutorial;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class ArrayListTest {

	public ArrayListTest() {
		// Enclosed test runnerだとテストクラスコンストラクタは実行されない？
		System.out.println("初期化");
	}

	/**
	 * これは実行されない
	 */
	@Test
	public void test() {
		System.out.println("test");
	}

	public static class 初期状態の時 {
		private ArrayList<String> sut;

		@Before
		public void setUp() throws Exception {
			sut = new ArrayList<>();
		}

		@Test
		public void sizeは0を返す() throws Exception {
			int actual = sut.size();
			assertThat(actual, is(0));
		}

		@Test
		public void addでHelloを追加するとget0はHelloを返す() {
			sut.add("Hello");
			assertThat(sut.size(), is(1));
			assertThat(sut.get(0), is("Hello"));
		}
	}

	public static class Helloが含まれる時 {
		private ArrayList<String> sut;

		@Before
		public void setUp() throws Exception {
			sut = new ArrayList<>();
			sut.add("Hello");
		}

		@Test
		public void sizeは1を返す() throws Exception {
			int actual = sut.size();
			assertThat(actual, is(1));
		}

		@Test
		public void addでWorldを追加するとget0はHelloをget1はWorldを返す() throws Exception {
			sut.add("World");
			assertThat(sut.size(), is(2));
			assertThat(sut.get(0), is("Hello"));
			assertThat(sut.get(1), is("World"));
		}
	}

	public static class Collectionの変更あれやこれ {
		private List<String> sut;

		@Before
		public void リスト作成() {
			sut = new ArrayList<>();
			sut.add("10");
			sut.add("2");
			sut.add("1");
			sut.add("あ");
		}

		@Test
		public void sort_test() {
			List<String> sortedList = new ArrayList<>(sut);

			Collections.sort(sortedList, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			});
			assertThat(sortedList.size(), is(4));
			assertThat(sortedList.get(0), is("1"));
			assertThat(sortedList.get(1), is("10"));
			assertThat(sortedList.get(2), is("2"));
			assertThat(sortedList.get(3), is("あ"));

			assertThat(sut.size(), is(4));
			assertThat(sut.get(0), is("10"));
			assertThat(sut.get(1), is("2"));
		}

		@Test
		public void filter_test() {
			List<String> filteredList = new ArrayList<>(sut);

			CollectionUtils.filter(filteredList, new Predicate<String>() {
				@Override
				public boolean evaluate(String arg0) {
					return arg0.startsWith("1");
				}
			});
			assertThat(filteredList.size(), is(2));
			assertThat(filteredList.get(0), is("10"));
			assertThat(filteredList.get(1), is("1"));

			assertThat(sut.size(), is(4));
		}
	}
}
