package com.calypso.boot.das_boot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.calypso.boot.das_boot.model.ShipWreck;;

public class ShipWreckStub {
	private static Map<Long, ShipWreck> wrecks = new HashMap<Long, ShipWreck>();
	private static Long idIndex = 3L;

	// populate initial wrecks
	static {
		ShipWreck a = new ShipWreck(1L, "U869", "A very deep German UBoat", "FAIR", 200, 44.12, 138.44, 1994);
		wrecks.put(1L, a);
		ShipWreck b = new ShipWreck(2L, "Thistlegorm", "British merchant boat in the Red Sea", "GOOD", 80, 44.12,
				138.44, 1994);
		wrecks.put(2L, b);
		ShipWreck c = new ShipWreck(3L, "S.S. Yongala", "A luxury passenger ship wrecked on the great barrier reef",
				"FAIR", 50, 44.12, 138.44, 1994);
		wrecks.put(3L, c);
	}

	public static List<ShipWreck> list() {
		return new ArrayList<ShipWreck>(wrecks.values());
	}

	public static ShipWreck create(ShipWreck wreck) {
		idIndex += idIndex;
		wreck.setId(idIndex);
		wrecks.put(idIndex, wreck);
		return wreck;
	}

	public static ShipWreck get(Long id) {
		return wrecks.get(id);
	}

	public static ShipWreck update(Long id, ShipWreck wreck) {
		wrecks.put(id, wreck);
		return wreck;
	}

	public static ShipWreck delete(Long id) {
		return wrecks.remove(id);
	}
}
