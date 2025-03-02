package com.aspiree.person.aspire.service;


import com.aspiree.person.aspire.dto.AddressDto;
import com.aspiree.person.aspire.model.Address;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AddressService {
    public AddressDto toDto(Address address) {
        AddressDto result = new AddressDto();
        result.setCity(address.getCity());
        result.setId(address.getId());
        result.setState(address.getState());
        return result;

    }

    public Set<AddressDto> toDto(Set<Address> addresses) {
        final Set<AddressDto> result =  addresses.stream()
                                            .map(address -> toDto(address))
                                            .collect(Collectors.toSet());
        return  result;
    }

    public Address toEntity(AddressDto address) {
        Address result = new Address();
        result.setCity(address.getCity());
        result.setId(address.getId());
        result.setState(address.getState());
        return result;
    }

    public Set<Address> toEntity(Set<AddressDto> addressesDtos) {
        final Set<Address> result =  addressesDtos.stream()
                .map(address -> toEntity(address))
                .collect(Collectors.toSet());
        return  result;
    }
}
