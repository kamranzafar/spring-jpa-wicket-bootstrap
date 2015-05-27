package org.kamranzafar.samples.wicket.template;

import javax.persistence.*;

/**
 * Created by kamran on 27/05/15.
 */
@Entity
@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "idgen", sequenceName = "image_id_seq")
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
    @Column(name = "id")
    private int id = -1;
    @Column(name = "name")
    private String name;
    @Column(name = "data", length = 10000)
    private byte[] data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
