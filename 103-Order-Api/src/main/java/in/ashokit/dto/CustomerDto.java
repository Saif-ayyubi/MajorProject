package in.ashokit.dto;

import jakarta.persistence.Column;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Data
public class CustomerDto {

    private Integer customerId;
    private String name;
    private String email;
    private String phoneNo;
}
