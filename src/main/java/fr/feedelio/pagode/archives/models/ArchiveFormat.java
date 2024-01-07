package fr.feedelio.pagode.archives.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

import fr.feedelio.pagode.parameters.models.CommonObject;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class ArchiveFormat extends CommonObject {

}
