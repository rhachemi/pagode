package fr.feedelio.pagode.archives.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import fr.feedelio.pagode.loges.models.Loge;
import fr.feedelio.pagode.parameters.models.Location;
import fr.feedelio.pagode.security.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Archive {
		
	
	private Integer archivetypeid;
	private Integer archivethemeid;	
	private Integer archivestatutid;
	private Integer archivesourceid;
	private Integer archivehistoireid;
	private Integer archiveformatid;
	private Integer archivelogeid;
	private Integer archivelocationid;
	private Long    archivedocumentid;
	private Integer archiveuserid;
 	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	private String titre;
	
	@ManyToOne
	@JoinColumn(name="archivetypeid", insertable=false, updatable=false)
	private ArchiveType archiveType;
 
	@ManyToOne
	@JoinColumn(name="archivethemeid", insertable=false, updatable=false)
	private ArchiveTheme archiveTheme;

	@ManyToOne
	@JoinColumn(name="archivestatutid", insertable=false, updatable=false)
	private ArchiveStatut archiveStatut;
	
	@ManyToOne
	@JoinColumn(name="archivesourceid", insertable=false, updatable=false)
	private ArchiveSource archiveSource;
 	
	@ManyToOne
	@JoinColumn(name="archivehistoireid", insertable=false, updatable=false)
	private ArchiveHistoire archiveHistoire;
 	
	@ManyToOne
	@JoinColumn(name="archiveformatid", insertable=false, updatable=false)
	private ArchiveFormat archiveFormat;
	
	@ManyToOne
	@JoinColumn(name="archivelogeid", insertable=false, updatable=false)
	private Loge archiveLoge;
	 
	@ManyToOne
	@JoinColumn(name="archivelocationid", insertable=false, updatable=false)
	private Location archiveLocation;
	
	@OneToOne
	@JoinColumn(name="archivedocumentid", insertable=false, updatable=false)
	private ArchiveDocument archiveDocument;
	
	@ManyToOne
	@JoinColumn(name="archiveuserid", insertable=false, updatable=false)
	private User archiveUser;
	
	
		
	private String archiveNumber;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd" )
	private Date enregistrementDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd" )
	private Date productionDate;
	
	private String description;
	
 	private String auteur;
	
	private String nombrepages;

	private String observations;	
	
 
	public void setUser(User user) {
		this.archiveUser = user;
	}
	public void setArchiveType(ArchiveType archiveType) {
	    this.archiveType = archiveType;}
	
	public void setArchiveTheme(ArchiveTheme archiveTheme) {
	    this.archiveTheme = archiveTheme;}
	
	public void setArchiveStatut(ArchiveStatut archiveStatut) {
	    this.archiveStatut = archiveStatut;}
	
	public void setArchiveSource(ArchiveSource archiveSource) {
	    this.archiveSource = archiveSource;}
	
	public void setArchiveFormat(ArchiveFormat archiveFormat) {
	    this.archiveFormat = archiveFormat;}
	
	public void setArchiveHistoire(ArchiveHistoire archiveHistoire) {
	    this.archiveHistoire = archiveHistoire;}
	
	public void setArchiveDocument(ArchiveDocument archiveDocument) {
	    this.archiveDocument = archiveDocument;}
	
		
	 
		
		
}
	

