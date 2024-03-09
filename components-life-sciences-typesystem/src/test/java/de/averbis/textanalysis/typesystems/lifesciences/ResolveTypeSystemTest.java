/*
 * Copyright 2022 Averbis GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.averbis.textanalysis.typesystems.lifesciences;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.uima.fit.factory.TypeSystemDescriptionFactory;
import org.apache.uima.resource.metadata.TypeDescription;
import org.apache.uima.resource.metadata.TypeSystemDescription;
import org.junit.jupiter.api.Test;

public class ResolveTypeSystemTest {

	public static void main(String[] args) throws Exception {
		TypeSystemDescription tsd = TypeSystemDescriptionFactory.createTypeSystemDescription(
				"de.averbis.lifesciences.types.LifeSciencesTypeSystem");
		tsd.resolveImports();
		for (TypeDescription t : tsd.getTypes()) {
			System.out.println("Type: " + t);
		}
		assertThat(tsd.getTypes()).hasSize(128);
	}
	
	@Test
	void thatTypeSystemCanBeAutoDetectedAndResolved() throws Exception {

		TypeSystemDescription tsd = TypeSystemDescriptionFactory.createTypeSystemDescription(
				"de.averbis.lifesciences.types.LifeSciencesTypeSystem");
		tsd.resolveImports();
		assertThat(tsd.getTypes()).hasSize(128);
	}
}
