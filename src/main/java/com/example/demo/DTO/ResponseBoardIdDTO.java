package com.example.demo.DTO;

import com.example.demo.model.board;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseBoardIdDTO {

    int status;
    String title;
    @Lob
    String summary;
    // image
}
