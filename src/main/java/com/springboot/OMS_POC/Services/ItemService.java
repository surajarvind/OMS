package com.springboot.OMS_POC.Services;

import com.springboot.OMS_POC.Payloads.AddressDto;
import com.springboot.OMS_POC.Payloads.ItemDto;

public interface ItemService
{
    ItemDto createItem(ItemDto itemDto);
}
