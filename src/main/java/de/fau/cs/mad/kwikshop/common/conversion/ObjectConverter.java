package de.fau.cs.mad.kwikshop.common.conversion;

public interface ObjectConverter<TIN, TOUT> {


    TOUT convert(TIN value);

}
