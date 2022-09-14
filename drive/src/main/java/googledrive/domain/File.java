package googledrive.domain;

import googledrive.DriveApplication;
import googledrive.domain.FileDeleted;
import googledrive.domain.FileUploaded;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "File_table")
@Data
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Long size;

    private Date createdTime;

    private String type;

    private String userId;

    @PostPersist
    public void onPostPersist() {
        FileUploaded fileUploaded = new FileUploaded(this);
        fileUploaded.publishAfterCommit();
    }

    @PostRemove
    public void onPostRemove() {
        FileDeleted fileDeleted = new FileDeleted(this);
        fileDeleted.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {}

    public static FileRepository repository() {
        FileRepository fileRepository = DriveApplication.applicationContext.getBean(
            FileRepository.class
        );
        return fileRepository;
    }
}
