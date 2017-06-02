package com.ztw.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class StreamAPIDemo {
	
	private List<Item> shoppingList;
	
	// 打印购物清单  
    @Test  
    public void printShoppingList(){  
        shoppingList.stream().forEach(e->execute(e));  
    }  
	
    public void execute(Item item){
    	System.out.println("##############");
    	System.out.println(item);
    	System.out.println("##############");
    }
    
	@Before  
    public void setUp() {  
        shoppingList = Lists.newArrayList();  
        shoppingList.add(new Item("iPad Air2",16500L));  
        shoppingList.add(new Item("iPhone 7", 7250L));  
        shoppingList.add(new Item("Rolex Watch", 28888L));  
        shoppingList.add(new Item("Electric Toothbrush", 388L));  
        shoppingList.add(new Item("Kindle Paperwhite", 1098L));  
        shoppingList.add(new Item("Coca Cola", 3L));  
    }
	
	@Test
	public void filter(){
		List<Item> list = shoppingList.stream().filter(f->f.getPrice() > 5000).collect(Collectors.toCollection(ArrayList::new));
		list.forEach(f->execute(f));
	}
	
	@Test
	public void sort(){
		Stream<Item> stream = shoppingList.stream().sorted((p1, p2)->p1.getItemName().compareTo(p2.getItemName()));
		stream.forEach(e->execute(e));
	}

}
