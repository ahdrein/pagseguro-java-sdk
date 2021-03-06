/*
 * 2007-2016 [PagSeguro Internet Ltda.]
 *
 * NOTICE OF LICENSE
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
 *
 * Copyright: 2007-2016 PagSeguro Internet Ltda.
 * Licence: http://www.apache.org/licenses/LICENSE-2.0
 */
package br.com.uol.pagseguro.api.common.domain.builder;

import java.util.List;

import br.com.uol.pagseguro.api.common.domain.Address;
import br.com.uol.pagseguro.api.common.domain.Phone;
import br.com.uol.pagseguro.api.common.domain.Sender;
import br.com.uol.pagseguro.api.common.domain.SenderDocument;
import br.com.uol.pagseguro.api.utils.Builder;

/**
 * Builder for Sender
 *
 * @author PagSeguro Internet Ltda.
 */
public final class SenderBuilder implements Builder<Sender> {

  private String email;

  private String name;

  private Phone phone;

  private Address address;

  private String cpf;

  private String hash;

  private List<SenderDocument> documents; // Alexandre Afonso

  /**
   * Set email of sender
   *
   * @param email Email
   * @return Builder for sender
   * @see Sender#getEmail()
   */
  public SenderBuilder withEmail(String email) {
    this.email = email;
    return this;
  }

  /**
   * Set name of sender
   *
   * @param name Name
   * @return Builder for sender
   * @see Sender#getName()
   */
  public SenderBuilder withName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Set phone of sender
   *
   * @param phone Phone
   * @return Builder for sender
   * @see Sender#getPhone()
   */
  public SenderBuilder withPhone(Phone phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Set phone of sender
   *
   * @param phoneBuilder Builder for Phone
   * @return Builder for sender
   * @see Sender#getPhone()
   */
  public SenderBuilder withPhone(Builder<Phone> phoneBuilder) {
    return withPhone(phoneBuilder.build());
  }

  /**
   * Set address for sender
   *
   * @param address Address
   * @return Builder for sender
   * @see Sender#getAddress()
   */
  public SenderBuilder withAddress(Address address) {
    this.address = address;
    return this;
  }


  /**
   * Set address for sender
   *
   * @param addressBuilder Builder for Address
   * @return Builder for sender
   * @see Sender#getAddress()
   */
  public SenderBuilder withAddress(Builder<Address> addressBuilder) {
    return withAddress(addressBuilder.build());
  }

  /**
   * Set cpf of sender
   *
   * @param cpf Cpf
   * @return Builder for sender
   * @see Sender#getCpf()
   */
  public SenderBuilder withCPF(String cpf) {
    this.cpf = cpf;
    return this;
  }

  /**
   * Set hash of sender
   *
   * @param hash Hash
   * @return Builder for sender
   * @see Sender#getHash()
   */
  public SenderBuilder withHash(String hash) {
    this.hash = hash;
    return this;
  }

  public SenderBuilder withDocuments(List<SenderDocument> documents) {
    this.documents = documents;
    return this;
  }

  /**
   * Build the sender
   *
   * @return Interface for sender
   * @see Sender
   */
  @Override
  public Sender build() {
    return new SimpleSender(this);
  }

  /**
   * Implementation of {@code Sender}
   */
  private static class SimpleSender implements Sender {

    private final SenderBuilder senderBuilder;

    SimpleSender(SenderBuilder senderBuilder) {
      this.senderBuilder = senderBuilder;
    }

    @Override
    public String getName() {
      return senderBuilder.name;
    }

    @Override
    public String getEmail() {
      return senderBuilder.email;
    }

    @Override
    public Phone getPhone() {
      return senderBuilder.phone;
    }

    @Override
    public Address getAddress() {
      return senderBuilder.address;
    }

    @Override
    public String getCpf() {
      return this.senderBuilder.cpf;
    }

    @Override
    public String getHash() {
      return senderBuilder.hash;
    }

    @Override
    public List<SenderDocument> getDocuments() { // Alexandre Afonso
      return senderBuilder.documents;
    }
  }

}
