package com.springboot.OMS_POC.Services.ServiceImpl;

import com.springboot.OMS_POC.Entities.Item;
import com.springboot.OMS_POC.Payloads.ItemDto;
import com.springboot.OMS_POC.Repositories.ItemRepo;
import com.springboot.OMS_POC.Services.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService
{
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ItemDto createItem(ItemDto itemDto) {
       Item item=this.dtoToItem(itemDto);
       Item savedItem=this.itemRepo.save(item);
        return this.itemToDto(savedItem);
    }

    public Item dtoToItem(ItemDto itemDto)
    {
        Item item= this.modelMapper.map(itemDto,Item.class);
        return  item;
    }

    public ItemDto itemToDto(Item item)
    {
        ItemDto itemDto=this.modelMapper.map(item,ItemDto.class);
        return itemDto;
    }
}
