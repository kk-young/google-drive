package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class FileDeleted extends AbstractEvent {

    private Long id;
    private String name;
    private Long size;
    private Date createdTime;
    private String type;
    private String userId;

    public FileDeleted(File aggregate) {
        super(aggregate);
    }

    public FileDeleted() {
        super();
    }
    // keep

}
