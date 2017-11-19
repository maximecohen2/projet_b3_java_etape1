import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class Parser {
	private String inputFile;
	private String category;
	private String labelFile;
	private String sheetFile;
	private float tva;
	
	private static Options configParameters(final Options otherOptions) {
		final Option inputFileOption = Option.builder("i")
	            .desc("fichier d'entrée CSV")
	            .hasArg(true)
	            .argName("nomFichierProduit")
	            .required(true)
	            .build();
		final Option categoryOption = Option.builder("categorie")
	            .desc("filtrer par catégoies")
	            .hasArg(true)
	            .argName("nomCatégorie")
	            .required(false)
	            .build();
		final Option labelFileOption = Option.builder("etiquette")
	            .desc("fichier Pdf de sortie des étiquettes produits")
	            .hasArg(true)
	            .argName("nomFichierPdf")
	            .required(false)
	            .build();
		final Option sheetFileOption = Option.builder("fiche")
	            .desc("fichier Pdf de sortie des fiches produits") 
	            .hasArg(true)
	            .argName("nomFichierPdf")
	            .required(false)
	            .build();
		final Option tvaOption = Option.builder("tva")
	            .desc("montant de la tva") 
	            .hasArg(true)
	            .argName("tva")
	            .required(false)
	            .build();
		
		final Options options = new Options();
		for (final Option fo : otherOptions.getOptions()) {
			options.addOption(fo);
		}
		options.addOption(inputFileOption);
		options.addOption(categoryOption);
		options.addOption(labelFileOption);
		options.addOption(sheetFileOption);
		options.addOption(tvaOption);
		return options;
	}
	
	private static Options configHelp() {
		final Option helpOption = Option.builder("h") 
	            .desc("Affiche le message d'aide") 
	            .build();
		final Options options = new Options();
		options.addOption(helpOption);
		return options;
	}
	
	public void parseParameters(String[] args) throws Exception {
		final Options helpOptions = configHelp();
		final Options options = configParameters(helpOptions);
		
		final CommandLineParser parser = new DefaultParser();
		
		final CommandLine helpLine = parser.parse(helpOptions, args, true);
		boolean helpMode = helpLine.hasOption("h");
		if (helpMode) {
			final HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("ProductToPdf", options, true);
			System.exit(0);
		}
		
		final CommandLine line = parser.parse(options, args);
		this.inputFile = line.getOptionValue("i");
		this.category = line.getOptionValue("categorie");
		this.labelFile = line.getOptionValue("etiquette");
		this.sheetFile = line.getOptionValue("fiche");
		if (this.sheetFile == null && this.labelFile == null) {
			throw new Exception("Need pdf outfile option");
		}
		final String tvaFromParameter = line.getOptionValue("tva", "20.0");
		this.tva = Float.valueOf(tvaFromParameter);
		
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getInputFile() {
		return inputFile;
	}

	public String getLabelFile() {
		return labelFile;
	}

	public String getSheetFile() {
		return sheetFile;
	}

	public float getTva() {
		return tva;
	}

	@Override
	public String toString() {
		return "Parser [inputFile=" + inputFile + ", category=" + category + ", labelFile=" + labelFile + ", sheetFile="
				+ sheetFile + ", tva=" + tva + "]";
	}
	
	

}
