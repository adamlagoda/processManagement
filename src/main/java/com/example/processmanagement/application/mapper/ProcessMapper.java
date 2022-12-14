package com.example.processmanagement.application.mapper;

import com.example.processmanagement.boundary.api.response.ProcessDto;
import com.example.processmanagement.boundary.client.response.SERProcess;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProcessMapper {
    List<ProcessDto> toDtos(List<SERProcess> source);
    ProcessDto toDto(SERProcess source);
}
