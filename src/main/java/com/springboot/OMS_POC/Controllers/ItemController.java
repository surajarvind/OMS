package com.springboot.OMS_POC.Controllers;


import com.springboot.OMS_POC.Payloads.ItemDto;
import com.springboot.OMS_POC.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ItemController
{
    @Autowired
    private ItemService itemService;

    @PostMapping("/item")
    public ItemDto createItem(@Valid @RequestBody ItemDto itemDto)
    {

        ItemDto result= this.itemService.createItem(itemDto);
        return result;
    }

}
