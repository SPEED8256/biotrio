package dk.kea.project.biotrio.Generator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class BookingGenerator implements IdentifierGenerator {

    public static final String generatorName = "myGenerator";

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object object) throws HibernateException {

        return Long.toHexString(Double.doubleToLongBits(Math.random())).substring(4, 10).toUpperCase();

    }
}