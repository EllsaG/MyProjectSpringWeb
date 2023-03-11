package com.myproject.controller.startinformation.update;


import com.myproject.controller.dto.startinformation.postget.StartInformationRequestDTO;
import com.myproject.controller.dto.startinformation.refresh.StartInformationRefreshResponseDTO;
import com.myproject.controller.dto.startinformation.update.UpdateRequestDTO;
import com.myproject.service.startinformation.update.StartInformationUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateController {

    private final StartInformationUpdateService startInformationUpdateService;

    @Autowired
    public UpdateController(StartInformationUpdateService startInformationUpdateService) {
        this.startInformationUpdateService = startInformationUpdateService;
    }

    @PostMapping("/startinformation/update")
    public StartInformationRefreshResponseDTO updateInfo(@RequestBody UpdateRequestDTO updateRequestDTO){
        return startInformationUpdateService.update(updateRequestDTO.getStartInformId(),
                updateRequestDTO.getName(),updateRequestDTO.getPower(),
                updateRequestDTO.getAmount(), updateRequestDTO.getKi(),
                updateRequestDTO.getCosf(), updateRequestDTO.getTgf());
    }



}
