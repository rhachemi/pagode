package fr.feedelio.pagode.archives.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@Table(name= "Documents")
public class ArchiveDocument {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 512, nullable = false, unique = true)
	private String name;
	private Long size;
	@Column(name = "upload_time")
	private Date uploadTime;
	private byte[] content;
	
	public ArchiveDocument(Long id, String name, Long size) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
	}
	
	
	public ArchiveDocument() {

	}

	public Long getId() {
		return id;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public byte[] getContent() {
		return content;
	}

	@Lob
	public void setContent(byte[] content) {
		this.content = content;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}
