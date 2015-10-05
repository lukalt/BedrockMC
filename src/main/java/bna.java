import com.google.common.collect.ImmutableSet;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.File;
import java.util.Map;
import java.util.Set;

import org.bedrockmc.api.BedrockMC;

/*
 * This class is used to load BedrockMC.
 */

public class bna implements bnk {
	public static final Set<String> a = ImmutableSet.<String> of("minecraft", "realms");
	private final Map<String, File> b;

	public bna(final Map<String, File> par1) {
		this.b = par1;
		if (BedrockMC.getInstance() == null) {
			BedrockMC.setClient(new BedrockClient(ave.A()));
		}
	}

	@Override
	public InputStream a(final jy a) throws IOException {
		final InputStream d = this.d(a);
		if (d != null) {
			return d;
		}
		final InputStream c = this.c(a);
		if (c != null) {
			return c;
		}
		throw new FileNotFoundException(a.a());
	}

	@SuppressWarnings("resource")
	public InputStream c(final jy a) throws FileNotFoundException {
		final File file = this.b.get(a.toString());
		return (file == null || !file.isFile()) ? null : new FileInputStream(
				file);
	}

	private InputStream d(final jy a) {
		return bna.class.getResourceAsStream("/assets/" + a.b() + "/" + a.a());
	}

	@Override
	public boolean b(final jy a) {
		return this.d(a) != null || this.b.containsKey(a.toString());
	}

	@Override
	public Set<String> c() {
		return bna.a;
	}

	@Override
	public <T extends bnw> T a(final bny par1, final String par2)
			throws IOException {
		try {
			final InputStream input = new FileInputStream(
					this.b.get("pack.mcmeta"));
			return bmx.a(par1, input, par2);
		} catch (RuntimeException ex) {
			return null;
		} catch (FileNotFoundException ex2) {
			return null;
		}
	}

	@Override
	public BufferedImage a() throws IOException {
		return bml
				.a(bna.class.getResourceAsStream("/" + new jy("pack.png").a()));
	}

	@Override
	public String b() {
		return "Default";
	}

}
