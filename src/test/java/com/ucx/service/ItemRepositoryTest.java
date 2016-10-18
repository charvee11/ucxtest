package com.ucx.service;

import com.ucx.domain.Item;
import org.apache.commons.collections.IteratorUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by avinashdash on 10/6/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Before
    @After
    public void cleanup() {
        itemRepository.deleteAll();
    }

    @Test
    public void testItemRepositoy() {
        for (int i = 0; i < 3; i++) {
            itemRepository.save(new Item("name"+i, Math.random()*100));
        }
        List<Item> items = IteratorUtils.toList(itemRepository.findAll().iterator());
        //test findAll
        assertEquals(3, items.size());
        items.get(0).setName("NewName");
        itemRepository.save(items);
        //saving the list shouldn't insert new items
        //test update
        items = IteratorUtils.toList(itemRepository.findAll().iterator());
        assertEquals(3, items.size());
        itemRepository.delete(items.get(0).getId());
        //test delete
        items = IteratorUtils.toList(itemRepository.findAll().iterator());
        assertEquals(2, items.size());

    }

}