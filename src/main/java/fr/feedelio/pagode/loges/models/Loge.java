package fr.feedelio.pagode.loges.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import fr.feedelio.pagode.loges.models.LogeStatut;
import fr.feedelio.pagode.loges.models.LogeType;
import fr.feedelio.pagode.archives.models.Archive;
import fr.feedelio.pagode.archives.models.ArchiveDocument;
import fr.feedelio.pagode.archives.models.ArchiveFormat;
import fr.feedelio.pagode.archives.models.ArchiveHistoire;
import fr.feedelio.pagode.archives.models.ArchiveSource;
import fr.feedelio.pagode.archives.models.ArchiveStatut;
import fr.feedelio.pagode.archives.models.ArchiveTheme;
import fr.feedelio.pagode.archives.models.ArchiveType;
import fr.feedelio.pagode.loges.models.LogeObedience;
import fr.feedelio.pagode.parameters.models.Location;
import fr.feedelio.pagode.security.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Loge  {
		
		private Integer logelocationid;
		private Integer logetypeid;
		private Integer logeobedienceid;
		private Integer logestatutid;

		
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		
	private String nom;
	 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date creationDate;
	
	private String description;
	
	 
	@ManyToOne
	@JoinColumn(name="logelocationid", insertable=false, updatable=false)	
	private Location logeLocation;

	
	
	@ManyToOne
	@JoinColumn(name="logetypeid", insertable=false, updatable=false)
	private LogeType logeType;
	 
	
	@ManyToOne
	@JoinColumn(name="logeobedienceid", insertable=false, updatable=false)
	private LogeObedience logeObedience;
	
	@ManyToOne
	@JoinColumn(name="logestatutid", insertable=false, updatable=false)
	private LogeStatut logeStatut;
	
	
	public void setLogeType(LogeType logeType) {
	    this.logeType = logeType;}
	
	public void setLogeStatut(LogeStatut logeStatut) {
	    this.logeStatut = logeStatut;}
	
	public void setObedience(LogeObedience logeObedience) {
	    this.logeObedience = logeObedience;}
	
	public void setLocation(LogeObedience logeObedience) {
	    this.logeObedience = logeObedience;}
	
}
