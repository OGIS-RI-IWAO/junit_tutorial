package junit.tutorial;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class ArrayListTest {
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
		public void addでWorldを追加するとget0はHelloを返す() throws Exception {
			sut.add("World");
			assertThat(sut.get(0), is("Hello"));
		}
		
		@Test
		public void addでWorldを追加するとget1はWorldを返す() throws Exception {
			sut.add("World");
			assertThat(sut.get(1), is("World"));
		}
		
	}
}
