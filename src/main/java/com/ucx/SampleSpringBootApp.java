
package com.ucx;

import com.ucx.service.ItemRepository;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ucx.domain.Item;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
public class SampleSpringBootApp {
	private Logger logger = Logger.getLogger("SampleSpringBootApp");
	@Autowired
	private ItemRepository itemRepository;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleSpringBootApp.class, args);
	}

	@PostConstruct
	public void run() {
		for (int i = 0; i < 10; i++) {
			itemRepository.save(new Item("name"+i, Math.random()*100));
		}
		List<Item> items = IteratorUtils.toList(itemRepository.findAll().iterator());
		items.stream().forEach(item -> {
			logger.info(String.format("Id: %s, Name: %s, Price: %f", item.getId(), item.getName(), item.getPrice()));
		});
	}

}
